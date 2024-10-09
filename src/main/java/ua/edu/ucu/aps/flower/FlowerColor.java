package ua.edu.ucu.aps.flower;

import lombok.Getter;

@Getter
public enum FlowerColor {

    RED("#FF0000"), WHITE("#FFFFFF"), YELLOW("#FFFF00");
    private String code;

    FlowerColor(String code) {
        this.code = code;
    }

}

