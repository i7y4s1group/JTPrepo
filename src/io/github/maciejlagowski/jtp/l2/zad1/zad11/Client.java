package io.github.maciejlagowski.jtp.l2.zad1.zad11;

import java.util.Objects;

class Client {
    Client(String[] name) {
        this.forename = name[0];
        this.surname = name[1];
    }

    private String forename;
    private String surname;

    String getForename() {
        return forename;
    }

    String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(forename, client.forename) &&
                Objects.equals(surname, client.surname);
    }
}
