package ru.geekbrains.intentactivity;

import android.os.Parcel;
import android.os.Parcelable;

public class ActivitySecondModel implements Parcelable {

    private final String name;
    private final String surname;
    private final int age;

    public ActivitySecondModel(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    protected ActivitySecondModel(Parcel in) {
        name = in.readString();
        surname = in.readString();
        age = in.readInt();
    }

    public static final Creator<ActivitySecondModel> CREATOR = new Creator<ActivitySecondModel>() {
        @Override
        public ActivitySecondModel createFromParcel(Parcel in) {
            return new ActivitySecondModel(in);
        }

        @Override
        public ActivitySecondModel[] newArray(int size) {
            return new ActivitySecondModel[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(surname);
        parcel.writeInt(age);
    }
}
