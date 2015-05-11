package com.azzarcher.colormanager;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.view.Window;

public class ColorManager {
    private static final int DEFAULT_DELAY = 1000;

    private Window mWindow;
    private android.support.v7.widget.Toolbar mSupportToolbar;
    private android.widget.Toolbar mToolbar;
    private Integer mToolbarColor;
    private Integer mStatusBarColor;

    public ColorManager setToolbar(android.support.v7.widget.Toolbar toolbar)
    throws AlreadySetToolbarException {
        if (mToolbar == null) {
            mSupportToolbar = toolbar;
        } else {
            throw new AlreadySetToolbarException();
        }
        return this;
    }

    public ColorManager setToolbar(android.widget.Toolbar toolbar)
    throws AlreadySetToolbarException {
        if (mSupportToolbar == null) {
            mToolbar = toolbar;
        } else {
            throw new AlreadySetToolbarException();
        }

        return this;
    }

    public ColorManager setToolbarColor(int toolbarColor) {
        // todo controls on the toolbarColor variable validity
        if (mToolbar == null) {
            mSupportToolbar.setBackgroundColor(toolbarColor);
        } else if (mSupportToolbar == null) {
            mToolbar.setBackgroundColor(toolbarColor);
        }
        mToolbarColor = toolbarColor;
        return this;
    }

    public ColorManager setStatusBarColor(Window window, int statusBarColor) {
        // todo controls on the statusBarColor variable validity
        window.setStatusBarColor(statusBarColor);
        mWindow = window;
        mStatusBarColor = statusBarColor;
        return this;
    }

    public void animateToolbar(int toColor) throws NoToolbarColorException {
        animateToolbar(toColor, DEFAULT_DELAY);
    }

    public void animateToolbar(int toColor, int delay) throws NoToolbarColorException {
        // todo controls on the toColor variable validity
        if (mToolbarColor != null) {
            ValueAnimator animator = ValueAnimator.ofObject(new ArgbEvaluator(), mToolbarColor, toColor);
            animator.setDuration(delay);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animator) {
                    int transitionColor = (int) animator.getAnimatedValue();
                    setToolbarColor(transitionColor);
                }
            });
            animator.start();
        } else throw new NoToolbarColorException();
    }

    public void animateStatusBar(int toColor) throws NoStatusBarColorException {
        animateStatusBar(toColor, DEFAULT_DELAY);
    }

    public void animateStatusBar(int toColor, int delay) throws NoStatusBarColorException {
        // todo controls on the toColor variable validity
        if (mStatusBarColor != null) {
            ValueAnimator animator = ValueAnimator.ofObject(new ArgbEvaluator(), mStatusBarColor, toColor);
            animator.setDuration(delay);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animator) {
                    int transitionColor = (int) animator.getAnimatedValue();
                    mWindow.setStatusBarColor(transitionColor);
                    mStatusBarColor = transitionColor;
                }
            });
            animator.start();
        } else throw new NoStatusBarColorException();
    }

    public static int generateDarkColorFromPrimary(int primaryColor) {
        // Darken prominent color
        float[] hsv = new float[3];
        Color.colorToHSV(primaryColor, hsv);
        hsv[2] *= 0.8f; // value component
        return Color.HSVToColor(hsv);
    }

    public class NoToolbarColorException extends RuntimeException {
        @Override
        public void printStackTrace() {
            System.err.println("No toolbar color has been set up for this color manager");
        }
    }

    public class NoStatusBarColorException extends RuntimeException {
        @Override
        public void printStackTrace() {
            System.err.println("No status bar color has been set up for this color manager");
        }
    }

    public class AlreadySetToolbarException extends RuntimeException {
        @Override
        public void printStackTrace() {
            System.err.println("Either set a toolbar or a supportToolbar");
        }
    }
}