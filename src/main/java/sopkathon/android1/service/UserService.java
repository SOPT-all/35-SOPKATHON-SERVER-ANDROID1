package sopkathon.android1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sopkathon.android1.dto.request.UserCreateRequestDTO;
import sopkathon.android1.dto.response.*;
import sopkathon.android1.repository.UserEntity;
import sopkathon.android1.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserService {
    private static UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserGetResponseDTO getUserInfo(){
        UserEntity user = userRepository.findByIsActive(true)
                .orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다"));

        return new UserGetResponseDTO(
                user.getName(),
                user.getAlcoholLevel(),
                0,
                user.getPart(),
                user.getJbti(),
                getMyALLRank()
        );
    }

    public void createUserInfo(UserCreateRequestDTO userCreateRequestDTO){
        UserEntity user = new UserEntity(
                userCreateRequestDTO.getName(),
                getJpScore(
                        userCreateRequestDTO.getSoju(),
                        userCreateRequestDTO.getBeer(),
                        userCreateRequestDTO.getMakgeolli(),
                        userCreateRequestDTO.getWine()
                ),
                userCreateRequestDTO.getLevel(),
                userCreateRequestDTO.getPart(),
                userCreateRequestDTO.getJbti()
        );

        // 저장소에 저장
        userRepository.save(user);
    }

    public AuthInfoResponseDTO getAuthInfo() {
        UserEntity user = userRepository.findByIsActive(true)
                .orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다"));

        return new AuthInfoResponseDTO(user.getAlcoholLevel(), user.getJbti());
    }

    public UserRankingResponseDTO getRankingInfo(String part) {
        List<UserEntity> userEntities;
        UserEntity user = userRepository.findByIsActive(true)
                .orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다"));
        int rank;

        if(getPart(part).equals("all")) {
            userEntities = userRepository.findAllRank();
            rank = getMyALLRank();
        } else {
            userEntities = userRepository.findAllRankWithPart(getPart(part));
            rank = getMyPartRank(user.getPart());
        }

        LoginUserDTO loginUserDTO = LoginUserDTO.builder()
                .name(user.getName())
                .imageUrl("")
                .part(user.getPart())
                .ranking(rank)
                .jpLevel(user.getAlcoholLevel())
                .jbti(user.getJbti())
                .isLoginUser(Boolean.TRUE)
                .build();

        List<RankingDTO> rankingDTOList = new ArrayList<>();
        int ranking = 1;
        for(UserEntity userEntity : userEntities) {
            rankingDTOList.add(
                    RankingDTO.builder()
                            .name(userEntity.getName())
                            .imageUrl("")
                            .part(userEntity.getPart())
                            .ranking(ranking)
                            .jpLevel(userEntity.getAlcoholLevel())
                            .jbti(userEntity.getJbti())
                            .isLoginUser(userEntity.getIsActive())
                            .build()
            );
            ranking ++;
        }

        return new UserRankingResponseDTO(loginUserDTO, rankingDTOList);
    }

    private Double getJpScore(Double soju, Double beer, Double makgeolli, Double wine) {
        return soju * 5.76 + beer * 2 + makgeolli * 4.5 + wine * 2.4;
    }

    private String getPart(String part) {
        log.info("분기1");
        log.info(part);
        if(part.equals("all")) {
            log.info("asdfdsafasdfasd");
            return "all";
        } else if(part.equals("plan")) {
            return "기획";
        } else if(part.equals("design")) {
            return "디자인";
        } else if(part.equals("android")) {
            return "안드로이드";
        } else if(part.equals("ios")) {
            return "아욧";
        } else if(part.equals("web")) {
            return "웹";
        } else if(part.equals("server")) {
            return "서버";
        } else {
            return null;
        }
    }

    private int getMyALLRank() {
        return userRepository.findUserRank();
    }

    private int getMyPartRank(String part) {
        return userRepository.findUserRankByPart(part);
    }

}

