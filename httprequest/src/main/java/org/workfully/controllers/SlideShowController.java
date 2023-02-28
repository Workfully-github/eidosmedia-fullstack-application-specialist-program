package org.workfully.controllers;

import org.workfully.models.Slides;
import org.workfully.models.Slideshow;

import java.util.ArrayList;

public class SlideShowController {

    private Slideshow slideshowModel;

    public SlideShowController(Slideshow slideshowModel) {
        this.slideshowModel = slideshowModel;
    }

    public String getSlideshowModelTitle() {
        return slideshowModel.getTitle();
    }

    public String getSlideshowModelAuthor() {
        return slideshowModel.getAuthor();
    }

    public String geSlideshowModeltDate() {
        return slideshowModel.getDate();
    }

    public ArrayList<Slides> getSlideshowModelSlides() {
        return slideshowModel.getSlides();
    }

    public void showSlideShowInfo() {
        try {

            present();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void present() {
        System.out.println("Main Key: " + slideshowModel.getClass().getSimpleName());
        System.out.println("author: " + slideshowModel.getAuthor());
        System.out.println("date: " + slideshowModel.getDate());
        System.out.println("title: " + slideshowModel.getTitle());

        for (Slides slide : slideshowModel.getSlides()) {
            System.out.println("title: " + slide.getTitle());
            System.out.println("type: " + slide.getType());

            if (slide.getItems() != null) {
                System.out.println("items: " + String.join(", ", cleanItems(slide.getItems())));
            }
        }
    }

    /*
     * Cleans array brackets and html tags;
     */
    private static ArrayList<String> cleanItems(ArrayList<String> items) {

        return new ArrayList<String>() {
            {
                for (String item : items) {
                    add(item.replaceAll("<em>|</em>", ""));
                }
            }
        };
    }
}
