package a13solutions.androidstudiol3c;

import android.content.res.Resources;

/**
 * Created by 13120dde on 2017-09-10.
 */

class Controller {

    private Instruction[] instructions = new Instruction[3];
    private InstructionFragment infoFragment;
    private WhatToDoFragment listFragment;
    private MainActivity mainActivity;

    private String choice;

    public Controller(MainActivity mainActivity) {
        this.mainActivity=mainActivity;
        infoFragment = new InstructionFragment();
        listFragment = new WhatToDoFragment();
        listFragment.setController(this);
        infoFragment.setController(this);
        initiateResources();
        mainActivity.setFrameInMainContainer(listFragment, false);
    }

    private void initiateResources() {
        Resources res= mainActivity.getResources();
        instructions[0]=new Instruction(res.getString(R.string.what_to_do), res.getString(R.string.content));
        instructions[1]=new Instruction(res.getString(R.string.what_to_do2), res.getString(R.string.content2));
        instructions[2]=new Instruction(res.getString(R.string.what_to_do3), res.getString(R.string.content3));
    }
/*
    public void setInfo(String s) {
        for (Instruction i : instructions){
            if(i.getWhatToDo().equals(s)){

                mainActivity.setFrameInMainContainer(infoFragment);
                infoFragment.setWhatToDo(s);
                infoFragment.setContent(i.getContent());
            }
        }
    }*/

    public void setInfo(String s){
        choice=s;
        mainActivity.setFrameInMainContainer(infoFragment, true);
    }

    public String getWhatToDo() {
        String whatToDo="", content="";
        for (Instruction i : instructions){
            if(i.getWhatToDo().equals(choice)){

                whatToDo=choice;
                content=i.getContent();
            }
        }

        return whatToDo+","+content;
    }
}
