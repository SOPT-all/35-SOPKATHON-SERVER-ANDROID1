package sopkathon.android1.service;

import org.springframework.stereotype.Service;
import sopkathon.android1.dto.request.UserCreateRequestDTO;
import sopkathon.android1.dto.response.UserGetResponseDTO;
import sopkathon.android1.repository.UserEntity;
import sopkathon.android1.repository.UserRepository;

@Service
public class UserService {
    public static UserGetResponseDTO getUserInfo;
    private static UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static UserGetResponseDTO getUserInfo(){
        UserEntity user = userRepository.findByIsActive(true)
                .orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다"));

        return new UserGetResponseDTO(
                user.getName(),
                user.getAlcoholLevel(),
                0,
                user.getJbti(),
                user.getRanking()
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
                11,
                userCreateRequestDTO.getJbti()
        );



        // 저장소에 저장
        userRepository.save(user);
    }

    Double getJpScore(Double soju, Double beer, Double makgeolli, Double wine) {
        return soju * 5.76 + beer * 2 + makgeolli * 4.5 + wine * 2.4;
    }

}

