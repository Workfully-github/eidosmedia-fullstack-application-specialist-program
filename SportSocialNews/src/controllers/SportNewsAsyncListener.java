package controllers;

import models.contents.Content;
import models.contents.TweetContent;

import java.util.ArrayList;

public interface SportNewsAsyncListener {

    public void onSuccess(Content content);
    public void onSuccess(ArrayList<Content> contents);
    public void onError(String error);


}
