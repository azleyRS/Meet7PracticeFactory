package com.fortests.meet7practicefactory;

public enum ItemTypes implements BaseItem {
    ITEM1(1),
    ITEM2(2),
    ITEM3(3),
    ITEM4(4);

    int type;

    ItemTypes(int type){
        this.type = type;
    }

    public int getType(){
        return type;
    }

}
