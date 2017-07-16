package com.londonappbrewery.destini;

/**
 * Created by ericvuong on 2017-07-16.
 */

public class Scenario {

    int storyText;
    int answer1;
    int answer2;

    public Scenario(int storyText, int answer1, int answer2) {

        this.storyText = storyText;
        this.answer1 = answer1;
        this.answer2 = answer2;

    }

    public int getStoryText() {
        return storyText;
    }

    public void setStoryText(int storyText) {
        this.storyText = storyText;
    }

    public int getAnswer1() {
        return answer1;
    }

    public void setAnswer1(int answer1) {
        this.answer1 = answer1;
    }

    public int getAnswer2() {
        return answer2;
    }

    public void setAnswer2(int answer2) {
        this.answer2 = answer2;
    }
}
