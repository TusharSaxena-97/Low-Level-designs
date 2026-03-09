package Logger;

import Logger.LoggerService.LoggerService;
import MeetingScheduler.NotificationService.NotificationService;

public class Client {

    public static void main(String args[])
    {
        LoggerService logger = LoggerService.getinstance("D:/DesignGithub/SystemDesign/Low-Level-designs/LowLevelDesign/src/Logger/Logs/");
        logger.Error("Error1");
        logger.Error("Error2");
        logger.Info("Some Task Completed 1");
        logger.Info("Some Task Completed 2");
        logger.Warn("Some Waring");
    }
}
