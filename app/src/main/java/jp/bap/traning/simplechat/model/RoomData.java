package jp.bap.traning.simplechat.model;

import java.util.Date;

import javax.annotation.Nullable;

import lombok.Data;

@Data
public class RoomData {
    int roomId;
    @Nullable
    String roomName;
    int type;
    @Nullable
    String avatar;
    @Nullable
    Date createdAt;
}
