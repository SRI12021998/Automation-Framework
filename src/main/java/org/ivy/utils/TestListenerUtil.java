package org.ivy.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListenerUtil implements ITestListener
{
	public void onTestStart(ITestResult result) 
    {
		LoggerUtil.info("======Starting "+result.getTestContext().getName()+" Test======");
    }


    public void onTestSuccess(ITestResult result) 
    {
    	LoggerUtil.info("======"+result.getName()+" Case Passed======");
    }


   public void onTestFailure(ITestResult result) 
    {

    }


   public void onTestSkipped(ITestResult result) 
    {
         
    }


   public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
    {
        
    }


   public void onTestFailedWithTimeout(ITestResult result) 
    {
        onTestFailure(result);
    }


   public void onStart(ITestContext context) 
    {
	   LoggerUtil.info("======Starting "+context.getName()+" TestSuite======");
    }


   public void onFinish(ITestContext context) 
    {
	   LoggerUtil.info("======Completing "+context.getName()+" TestSuite======");
    }
}
