package org.comstudy.myweb.board.model;

import java.util.Date;

public class BoardDTO {
	private Long seq;
	private String title;
	private String content;
	private Date writeDate = new Date();
	private String writer;
	private Long cnt;
	
	public BoardDTO() {
		this(0L, "", "", new Date(), "", 0L);
	}

	public BoardDTO(Long seq, String title, String content, Date writeDate, String writer, Long cnt) {
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.writeDate = writeDate;
		this.writer = writer;
		this.cnt = cnt;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Long getCnt() {
		return cnt;
	}

	public void setCnt(Long cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "BoardDTO [seq=" + seq + ", title=" + title + ", content=" + content + ", writeDate=" + writeDate
				+ ", writer=" + writer + ", cnt=" + cnt + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((seq == null) ? 0 : seq.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardDTO other = (BoardDTO) obj;
		if (seq == null) {
			if (other.seq != null)
				return false;
		} else if (!seq.equals(other.seq))
			return false;
		return true;
	}
}
