package com.dzeru.ozontest.listeners;

import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.StepResult;
import com.dzeru.ozontest.util.ScreenshotMaker;

public class StepListener implements StepLifecycleListener {

    @Override
    public void beforeStepStop(StepResult stepResult) {
        ScreenshotMaker.takeScreenshot();
    }
}