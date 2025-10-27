package customListeners;

import Validation.Validation;
import logs.LogsManager;
import media.GetScreenshot;
import org.testng.*;
import Validation.FileUitils;

import java.io.File;

public class TestNGListeners implements IInvokedMethodListener, IExecutionListener, ITestListener {

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) { /* compiled code */

        if (method.isTestMethod())
            LogsManager.info(testResult.getName() + " started");
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod())
            Validation.assertAll(testResult);
            LogsManager.info(testResult.getName() + " finished");
    }

    public void onExecutionStart() { /* compiled code */

        LogsManager.info("starting");
        FileUitils.cleanfile(new File(GetScreenshot.SCREENPATH));
        FileUitils.cleanfile(new File(LogsManager.LOGS_PATH));
        FileUitils.createdirectory(GetScreenshot.SCREENPATH);
    }

    public void onExecutionFinish() { /* compiled code */

        LogsManager.info("finishing");
    }

    public void onTestSuccess(org.testng.ITestResult result) { /* compiled code */
        LogsManager.info(result.getName() + " Passed");
    }

    public void onTestFailure(org.testng.ITestResult result) {
        LogsManager.info(result.getName() + " failed");
    }

}

