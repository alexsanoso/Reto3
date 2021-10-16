package com.reto3.modelo;

/**
 *
 * @author Alexander
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "message")
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer idMessage;
    @Column(name = "messageText")
    private String messageText;

    @ManyToOne
    @JoinColumn(name = "idMachine")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Machine machine;
    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Client client;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}

