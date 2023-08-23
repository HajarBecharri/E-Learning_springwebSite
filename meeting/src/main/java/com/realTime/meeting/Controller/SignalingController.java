package com.realtime.meeting.Controller;

import com.realtime.meeting.dto.CallOffer;
import com.realtime.meeting.dto.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class SignalingController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/call/{seanceId}/offer")
    public void handleOffer(@DestinationVariable Long seanceId, CallOffer offer) {
        // Handle offer, process and notify recipient
        messagingTemplate.convertAndSend("/call/" + seanceId + "/offer", offer);
    }

    @MessageMapping("/call/{seanceId}/chat")
    public void handleChatMessage(@DestinationVariable Long seanceId, ChatMessage chatMessage) {
        // Handle chat message, process and broadcast to participants
        messagingTemplate.convertAndSend("/call/" + seanceId + "/chat", chatMessage);
    }
}
