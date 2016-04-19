package ru.stga.pft.mantis.model;

/**
 * Created by Homosapiens on 15.04.2016.
 */
public class MailMessage {

  public String to;
  public String text;

  public MailMessage(String to, String text) {
    this.to = to;
    this.text = text;
  }
}