package com.cg.tms.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class TicketDetails {

	@Id
	private String ticketId;

	@OneToOne
	private Route route;
	private String status;

	public TicketDetails() {

	}

	public String getTicketId() {

		return ticketId;
	}

	public void setTicketId(String ticketId) {

		this.ticketId = ticketId;
	}

	public Route getRoute() {

		return route;
	}

	public void setRoute(Route route) {

		this.route = route;
	}

	public String getStatus() {

		return status;
	}

	public void setStatus(String status) {

		this.status = status;
	}

	@Override
	public String toString() {

		return "TicketDetails [ticketId=" + ticketId + ", status=" + status + "]";
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicketDetails other = (TicketDetails) obj;
		if (ticketId == null) {
			if (other.ticketId != null)
				return false;
		} else if (!ticketId.equals(other.ticketId))
			return false;
		return true;
	}

	@Override
	public int hashCode() {

		return Objects.hash(ticketId);
	}

}