/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phone;

import java.lang.Math;

public class Cellphone implements Phone {
  String merk;
  String type;
  int batteryLevel;
  int status;
  int volume;
  Contact[] contacts;
  int contactCount;

  public Cellphone(String merk, String type) {
    this.merk = merk;
    this.type = type;
    this.batteryLevel = (int) (Math.random() * (100 - 0 + 1) + 0);
    this.contactCount = 0;
    this.contacts = new Contact[100]; // Batasan maksimum 100 kontak
  }

  public void powerOn() {
    if (this.status == 0) {
      this.status = 1;
      System.out.println("Ponsel menyala");
    } else {
      System.out.println("Ponsel sudah menyala");
    }
  }

  public void powerOff() {
    if (this.status == 1) {
      this.status = 0;
      System.out.println("Ponsel mati");
    } else {
      System.out.println("Ponsel sudah mati");
    }
  }

  public void volumeUp() {
    if (this.status == 0) {
      System.out.println("Ponsel mati. Tidak dapat menaikkan volume");
    } else {
      if (this.volume < MAX_VOLUME) {
        this.volume++;
      }
    }
  }

  public void volumeDown() {
    if (this.volume > MIN_VOLUME) {
      this.volume--;
    }
  }

  public int getVolume() {
    return this.volume;
  }

  public void topUpPulsa(int amount) {
    System.out.println("Top up pulsa sebesar " + amount + " berhasil");
  }

  public int getSisaPulsa() {
    // Logika untuk mendapatkan sisa pulsa
    return 5000; // Contoh nilai sisa pulsa
  }

  public void tambahKontak(String nama, String nomor) {
    if (this.contactCount < contacts.length) {
      Contact contact = new Contact(nama, nomor);
      contacts[contactCount] = contact;
      contactCount++;
      System.out.println("Kontak berhasil ditambahkan");
    } else {
      System.out.println("Kontak penuh. Tidak dapat menambahkan kontak baru");
    }
  }

  public void lihatSemuaKontak() {
    if (this.contactCount > 0) {
      System.out.println("Daftar Kontak:");
      for (int i = 0; i < contactCount; i++) {
        System.out.println("Nama: " + contacts[i].getNama() + ", Nomor: " + contacts[i].getNomor());
      }
    } else {
      System.out.println("Tidak ada kontak");
    }
  }

  public void cariKontak(String nama) {
    boolean found = false;
    for (int i = 0; i < contactCount; i++) {
      if (contacts[i].getNama().equalsIgnoreCase(nama)) {
        System.out.println("Kontak ditemukan:");
        System.out.println("Nama: " + contacts[i].getNama() + ", Nomor: " + contacts[i].getNomor());
        found = true;
        break;
      }
    }
    if (!found) {
      System.out.println("Kontak dengan nama " + nama + " tidak ditemukan");
    }
  }
}

