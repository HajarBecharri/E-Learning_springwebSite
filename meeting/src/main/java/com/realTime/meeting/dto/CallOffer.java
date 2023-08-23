package com.realtime.meeting.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CallOffer {
    private String audioCodec;
    private String videoCodec;
    private int resolutionWidth;
    private int resolutionHeight;
    // Other fields for media configuration

    // Getters and setters
}
