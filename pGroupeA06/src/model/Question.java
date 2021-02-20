package model;

import com.google.gson.Gson;

import enumerations.Theme;

public class Question {
	
	private String author;
	private Theme theme;
	private String subject;
	private String challenge;
	private String answer;
	
	
	public Question(String author, Theme theme, String subject, String challenge, String answer) {
		this.author = author;
		this.theme = theme;
		this.subject = subject;
		this.challenge = challenge;
		this.answer = answer;
	}



	public String toJson() {
		return new Gson().toJson(this);
	}
	
	public Question fromJson(String json) {
		return new Gson().fromJson(json,Question.class);
	}
	
	
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getChallenge() {
		return challenge;
	}

	public void setChallenge(String challenge) {
		this.challenge = challenge;
	}

	public String getAnswer() {
		return answer;
	}

	@Override
	public String toString() {
		return "Question [author=" + author + ", theme=" + theme + ", subject=" + subject + ", challenge=" + challenge
				+ ", answer=" + answer + "]\n";
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (theme != other.theme)
			return false;
		return true;
	}
	
}