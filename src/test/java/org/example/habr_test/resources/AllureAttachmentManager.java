package org.example.habr_test.resources;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AllureAttachmentManager {

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] screenshot(){
        return ((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
