package kr.ac.kgu.kpserver.domain.activity;

import kr.ac.kgu.kpserver.domain.mbti.MBTI;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ActivitySolutionController {

    //feature 이름 변경
    private final UserService userService;
    private final ActivityService activityService;

    //사용자 설문지 입력, 스트레스 점수 증가
    @GetMapping("/userInput")
    public String userInputForm(Model model){
        model.addAttribute("userInputForm", new UserInputForm());
        return "userInput";
    }
    @PostMapping("/userInputScore")
    public String userInputScore(Model model, UserInputForm userInputForm, Principal principal){
        int score = userInputForm.score;
        long userId = Long.parseLong(principal.getName());
        User user = userService.findUserByIdOrNull(userId);
        user.setStressPoint(score);

        model.addAttribute("score", score);
        model.addAttribute("user", user);

        return "user_stress_score";
    }


    //사용자 솔루션 출력
    @PostMapping("/userSolution")
    public String userSolution(HttpServletRequest request, @RequestParam("userId") Long userId, @RequestParam("stressScore") int stressScore, Principal principal){

        HttpSession session =request.getSession();
        userId = Long.parseLong(principal.getName());
        User user = userService.findUserByIdOrNull(userId);
        String userMBTI = String.valueOf(user.getMbti());

        List<Activity> activities = activityService.allActivityView();
        Activity userActivity = null;
        for(Activity findActivity:activities){
            if(userMBTI.substring(0) == (String.valueOf(findActivity.getPersonality()))){
                userActivity = findActivity;
                break;
            }
        }
        return "redirect:/";

    }

}
