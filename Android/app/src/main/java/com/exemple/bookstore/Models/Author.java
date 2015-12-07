package com.exemple.bookstore.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jonathan on 04/12/2015.
 */
public class Author implements Parcelable {

    private int     id;
    private String  firstname;
    private String  lastname;
    private String  biography;
    private String  image;

    public Author(int id, String firstname, String lastname, String biography, String image) {
        this.id         = id;
        this.firstname  = firstname;
        this.lastname   = lastname;
        this.biography  = biography;
        this.image      = image;
    }

    protected Author(Parcel in) {
        id = in.readInt();
        firstname = in.readString();
        lastname = in.readString();
        biography = in.readString();
        image = in.readString();
    }

    public static final Creator<Author> CREATOR = new Creator<Author>() {
        @Override
        public Author createFromParcel(Parcel in) {
            return new Author(in);
        }

        @Override
        public Author[] newArray(int size) {
            return new Author[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(firstname);
        dest.writeString(lastname);
        dest.writeString(biography);
        dest.writeString(image);
    }


}
