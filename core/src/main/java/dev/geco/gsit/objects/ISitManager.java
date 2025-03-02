package dev.geco.gsit.objects;

import java.util.*;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;

public interface ISitManager {

    double STAIR_XZ_OFFSET = 0.123d;

    double STAIR_Y_OFFSET = 0.5d;

    int getFeatureUsedCount();

    void resetFeatureUsedCount();

    List<GSeat> getSeats();

    boolean isSitting(Player Player);

    GSeat getSeat(Player Player);

    void clearSeats();

    boolean kickSeat(Block Block, Player Player);

    GSeat createSeat(Block Block, Player Player);

    GSeat createSeat(Block Block, Player Player, boolean Rotate, double XOffset, double YOffset, double ZOffset, float SeatRotation, boolean SitAtBlock, boolean GetUpSneak);

    void moveSeat(GSeat Seat, BlockFace Face);

    boolean removeSeat(GSeat Seat, GetUpReason Reason);

    boolean removeSeat(GSeat Seat, GetUpReason Reason, boolean Safe);

}