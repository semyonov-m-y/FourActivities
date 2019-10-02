package ru.semenovmy.learning.fouractivities;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Collections;
import java.util.List;

class TestModel implements Parcelable {

    String mItemOne;
    String mItemTwo;
    List<String> mItemsListOne;
    List<String> mItemsListTwo;

    protected TestModel(String itemOne, String itemTwo, List<String> itemsListOne, List<String> itemsListTwo) {
        mItemOne = itemOne;
        mItemTwo = itemTwo;
        mItemsListOne = itemsListOne;
        mItemsListTwo = itemsListTwo;
    }

    protected TestModel(Parcel in) {
        String[] data = new String[4];

        in.readStringArray(data);
        mItemOne = data[0];
        mItemTwo = data[1];
        mItemsListOne = Collections.singletonList(data[2]);
        mItemsListTwo = Collections.singletonList(data[3]);
    }

    public static final Creator<TestModel> CREATOR = new Creator<TestModel>() {
        @Override
        public TestModel createFromParcel(Parcel in) {
            return new TestModel(in);
        }

        @Override
        public TestModel[] newArray(int size) {
            return new TestModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {mItemOne, mItemTwo, String.valueOf(mItemsListOne), String.valueOf(mItemsListTwo)});
    }

    public String getmItemOne() {
        return mItemOne;
    }

    public void setmItemOne(String mItemOne) {
        this.mItemOne = mItemOne;
    }

    public String getmItemTwo() {
        return mItemTwo;
    }

    public void setmItemTwo(String mItemTwo) {
        this.mItemTwo = mItemTwo;
    }

    public List<String> getmItemsListOne() {
        return mItemsListOne;
    }

    public void setmItemsListOne(List<String> mItemsListOne) {
        this.mItemsListOne = mItemsListOne;
    }

    public List<String> getmItemsListTwo() {
        return mItemsListTwo;
    }

    public void setmItemsListTwo(List<String> mItemsListTwo) {
        this.mItemsListTwo = mItemsListTwo;
    }
}
