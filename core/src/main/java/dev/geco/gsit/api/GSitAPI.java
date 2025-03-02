package dev.geco.gsit.api;

import java.util.*;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Pose;

import dev.geco.gsit.GSitMain;
import dev.geco.gsit.objects.*;

public class GSitAPI {

    /**
     * Returns the Plugin-Instance for GSit
     * @author Gecolay
     * @since 1.0.0
     * @return Plugin-Instance
     */
    public static GSitMain getInstance() { return GSitMain.getInstance(); }

    /**
     * Checks if a Player can sit by click
     * @author Gecolay
     * @since 1.0.0
     * @param Player Player
     * @return <code>true</code> if the Player can sit
     */
    public static boolean canSit(Player Player) {
        return getInstance().getToggleManager().canSit(Player.getUniqueId());
    }

    /**
     * Sets if a Player can sit by click
     * @author Gecolay
     * @since 1.0.0
     * @param Player Player
     */
    public static void setCanSit(Player Player, boolean CanSit) {
        getInstance().getToggleManager().setCanSit(Player.getUniqueId(), CanSit);
    }

    /**
     * Checks if a Player is currently sitting
     * @author Gecolay
     * @since 1.0.0
     * @param Player Player for this Seat
     * @return <code>true</code> if the Player is sitting
     */
    public static boolean isSitting(Player Player) {
        return getInstance().getSitManager().isSitting(Player);
    }

    /**
     * Gets all Seats
     * @author Gecolay
     * @since 1.0.0
     * @return List of all Seat-Objects
     */
    public static List<GSeat> getSeats() {
        return getInstance().getSitManager().getSeats();
    }

    /**
     * Gets the Seat of a Player
     * @author Gecolay
     * @since 1.0.0
     * @param Player Player for this Seat
     * @return Seat-Object or <code>null</code> if there was no Seat
     */
    public static GSeat getSeat(Player Player) {
        return getInstance().getSitManager().getSeat(Player);
    }

    /**
     * Gets all Seats of a Block
     * @author Gecolay
     * @since 1.0.0
     * @param Block Block for this Seats
     * @return List of Seat-Objects
     */
    public static List<GSeat> getSeats(Block Block) {
        return getInstance().getSitUtil().getSeats(Block);
    }

    /**
     * Gets all Seats of a List of Blocks
     * @author Gecolay
     * @since 1.0.0
     * @param Blocks Blocks for this Seats
     * @return List of Seat-Objects
     */
    public static List<GSeat> getSeats(List<Block> Blocks) {
        return getInstance().getSitUtil().getSeats(Blocks);
    }

    /**
     * Creates a new Seat on a Block for a Player
     * @author Gecolay
     * @since 1.0.0
     * @param Block Block which should be connected to the Seat-Object
     * @param Player Player for this Seat
     * @return Seat-Object or <code>null</code> if the creation was canceled
     */
    public static GSeat createSeat(Block Block, Player Player) {
        return getInstance().getSitManager().createSeat(Block, Player);
    }

    /**
     * Creates a new Seat on a Block for a Player.
     * The Seat can be static or rotating.
     * @author Gecolay
     * @since 1.0.0
     * @param Block Block which should be connected to the Seat-Object
     * @param Player Player for this Seat
     * @param Rotate Should this Seat rotate with direction the player is facing
     * @param SeatRotationYaw The default Rotation of the Seat
     * @param SitAtBlock Should the Seat be aligned with the Block (<code>true</code>) or the Player (<code>false</code>)
     * @return Seat-Object or <code>null</code> if the creation was canceled
     */
    public static GSeat createSeat(Block Block, Player Player, boolean Rotate, float SeatRotationYaw, boolean SitAtBlock) {
        return createSeat(Block, Player, Rotate, 0d, 0d, 0d, SeatRotationYaw, SitAtBlock);
    }

    /**
     * Creates a new Seat on a Block for a Player.
     * The Seat can be static or rotating.
     * The seat can be moved to with an Offset
     * @author Gecolay
     * @since 1.0.0
     * @param Block Block which should be connected to the Seat-Object
     * @param Player Player for this Seat
     * @param Rotate Should this Seat rotate with direction the player is facing
     * @param XOffset The X-Coordinate-Offset for the Seat
     * @param YOffset The Y-Coordinate-Offset for the Seat
     * @param ZOffset The Z-Coordinate-Offset for the Seat
     * @param SeatRotationYaw The default Rotation of the Seat
     * @param SitAtBlock Should the Seat be aligned with the Block (<code>true</code>) or the Player (<code>false</code>)
     * @return Seat-Object or <code>null</code> if the creation was canceled
     */
    public static GSeat createSeat(Block Block, Player Player, boolean Rotate, double XOffset, double YOffset, double ZOffset, float SeatRotationYaw, boolean SitAtBlock) {
        return createSeat(Block, Player, Rotate, XOffset, YOffset, ZOffset, SeatRotationYaw, SitAtBlock, true);
    }

    /**
     * Creates a new Seat on a Block for a Player.
     * The Seat can be static or rotating.
     * The seat can be moved to with an Offset
     * @author Gecolay
     * @since 1.0.4
     * @param Block Block which should be connected to the Seat-Object
     * @param Player Player for this Seat
     * @param Rotate Should this Seat rotate with direction the player is facing
     * @param XOffset The X-Coordinate-Offset for the Seat
     * @param YOffset The Y-Coordinate-Offset for the Seat
     * @param ZOffset The Z-Coordinate-Offset for the Seat
     * @param SeatRotationYaw The default Rotation of the Seat
     * @param SitAtBlock Should the Seat be aligned with the Block (<code>true</code>) or the Player (<code>false</code>)
     * @param GetUpSneak Should the Player be able to get up by sneaking
     * @return Seat-Object or <code>null</code> if the creation was canceled
     */
    public static GSeat createSeat(Block Block, Player Player, boolean Rotate, double XOffset, double YOffset, double ZOffset, float SeatRotationYaw, boolean SitAtBlock, boolean GetUpSneak) {
        return getInstance().getSitManager().createSeat(Block, Player, Rotate, XOffset, YOffset, ZOffset, SeatRotationYaw, SitAtBlock, GetUpSneak);
    }

    /**
     * Moves an existing Seat
     * @author Gecolay
     * @since 1.0.4
     * @param Seat The Seat
     * @param Direction The Direction in which the Seat should get moved
     */
    public static void moveSeat(GSeat Seat, BlockFace Direction) {
        getInstance().getSitManager().moveSeat(Seat, Direction);
    }

    /**
     * Removes an existing Seat
     * @author Gecolay
     * @since 1.0.0
     * @param Seat The Seat
     * @param Reason The Reason why the Seat gets removed
     * @return <code>true</code> or <code>false</code> if the deletion was canceled
     */
    public static boolean removeSeat(GSeat Seat, GetUpReason Reason) {
        return getInstance().getSitManager().removeSeat(Seat, Reason);
    }

    /**
     * Removes an existing Seat.
     * The Get-Up-Safe-Teleport can be disabled
     * @author Gecolay
     * @since 1.0.0
     * @param Seat The Seat
     * @param Reason The Reason why the Seat gets removed
     * @param Safe Should the Player get teleported to a safe Position
     * @return <code>true</code> or <code>false</code> if the deletion was canceled
     */
    public static boolean removeSeat(GSeat Seat, GetUpReason Reason, boolean Safe) {
        return getInstance().getSitManager().removeSeat(Seat, Reason, Safe);
    }

    /**
     * Checks if a Player can sit on a Player by click
     * @author Gecolay
     * @since 1.0.0
     * @param Player Player
     * @return <code>true</code> if the Player can sit on a Player
     */
    public static boolean canPlayerSit(Player Player) {
        return getInstance().getToggleManager().canPlayerSit(Player.getUniqueId());
    }

    /**
     * Sets if a Player can sit on a Player by click
     * @author Gecolay
     * @since 1.0.0
     * @param Player Player
     */
    public static void setCanPlayerSit(Player Player, boolean CanPlayerSit) {
        getInstance().getToggleManager().setCanPlayerSit(Player.getUniqueId(), CanPlayerSit);
    }

    /**
     * Let a Player sit on top of another Player (Target)
     * @author Gecolay
     * @since 1.0.0
     * @param Player Player
     * @param Target Target
     * @return <code>true</code> or <code>false</code> if the action was canceled
     */
    public static boolean sitOnPlayer(Player Player, Player Target) {
        return getInstance().getPlayerSitManager().sitOnPlayer(Player, Target);
    }

    /**
     * Stop a PlayerSit
     * @author Gecolay
     * @since 1.0.0
     * @param Entity Entity
     * @param Reason The Reason why the PlayerSit is stopped
     * @return <code>true</code> or <code>false</code> if the stop was canceled
     */
    public static boolean stopPlayerSit(Entity Entity, GetUpReason Reason) {
        return getInstance().getPlayerSitManager().stopPlayerSit(Entity, Reason);
    }

    /**
     * Checks if a Player is currently posing
     * @author Gecolay
     * @since 1.0.0
     * @param Player Player for this PoseSeat
     * @return <code>true</code> if the Player is posing
     */
    public static boolean isPosing(Player Player) {
        return getInstance().getPoseManager() != null && getInstance().getPoseManager().isPosing(Player);
    }

    /**
     * Gets all PoseSeats
     * @author Gecolay
     * @since 1.0.0
     * @return List of all PoseSeat-Objects
     */
    public static List<IGPoseSeat> getPoses() {
        return getInstance().getPoseManager() != null ? getInstance().getPoseManager().getPoses() : new ArrayList<>();
    }

    /**
     * Gets the PoseSeat of a Player
     * @author Gecolay
     * @since 1.0.0
     * @param Player Player for this PoseSeat
     * @return PoseSeat-Object or <code>null</code> if there was no PoseSeat
     */
    public static IGPoseSeat getPose(Player Player) {
        return getInstance().getPoseManager() != null ? getInstance().getPoseManager().getPose(Player) : null;
    }

    /**
     * Gets all PoseSeats of a Block
     * @author Gecolay
     * @since 1.0.0
     * @param Block Block for this PoseSeats
     * @return List of PoseSeat-Objects
     */
    public static List<IGPoseSeat> getPoses(Block Block) {
        return getInstance().getPoseManager() != null ? getInstance().getPoseUtil().getPoses(Block) : new ArrayList<>();
    }

    /**
     * Gets all PoseSeats of a List of Blocks
     * @author Gecolay
     * @since 1.0.0
     * @param Blocks Blocks for this PoseSeats
     * @return List of PoseSeat-Objects
     */
    public static List<IGPoseSeat> getPoses(List<Block> Blocks) {
        return getInstance().getPoseManager() != null ? getInstance().getPoseUtil().getPoses(Blocks) : new ArrayList<>();
    }

    /**
     * Creates a new PoseSeat on a Block for a Player
     * @author Gecolay
     * @since 1.0.0
     * @param Block Block which should be connected to the PoseSeat-Object
     * @param Player Player for this PoseSeat
     * @param Pose Player-Pose {@link Pose}
     * @return PoseSeat-Object or <code>null</code> if the creation was canceled
     */
    public static IGPoseSeat createPose(Block Block, Player Player, Pose Pose) {
        return getInstance().getPoseManager() != null ? getInstance().getPoseManager().createPose(Block, Player, Pose) : null;
    }

    /**
     * Creates a new PoseSeat on a Block for a Player.
     * The PoseSeat can be static or rotating.
     * @author Gecolay
     * @since 1.0.0
     * @param Block Block which should be connected to the PoseSeat-Object
     * @param Player Player for this PoseSeat
     * @param Pose Player-Pose {@link Pose}
     * @param SeatRotationYaw The default Rotation of the PoseSeat
     * @param SitAtBlock Should the PoseSeat be aligned with the Block (<code>true</code>) or the Player (<code>false</code>)
     * @return PoseSeat-Object or <code>null</code> if the creation was canceled
     */
    public static IGPoseSeat createPose(Block Block, Player Player, Pose Pose, float SeatRotationYaw, boolean SitAtBlock) {
        return createPose(Block, Player, Pose, 0d, 0d, 0d, SeatRotationYaw, SitAtBlock);
    }

    /**
     * Creates a new PoseSeat on a Block for a Player.
     * The PoseSeat can be static or rotating.
     * The PoseSeat can be moved to with an Offset
     * @author Gecolay
     * @since 1.0.0
     * @param Block Block which should be connected to the PoseSeat-Object
     * @param Player Player for this PoseSeat
     * @param Pose Player-Pose {@link Pose}
     * @param XOffset The X-Coordinate-Offset for the PoseSeat
     * @param YOffset The Y-Coordinate-Offset for the PoseSeat
     * @param ZOffset The Z-Coordinate-Offset for the PoseSeat
     * @param SeatRotationYaw The default Rotation of the PoseSeat
     * @param SitAtBlock Should the PoseSeat be aligned with the Block (<code>true</code>) or the Player (<code>false</code>)
     * @return PoseSeat-Object or <code>null</code> if the creation was canceled
     */
    public static IGPoseSeat createPose(Block Block, Player Player, Pose Pose, double XOffset, double YOffset, double ZOffset, float SeatRotationYaw, boolean SitAtBlock) {
        return createPose(Block, Player, Pose, XOffset, YOffset, ZOffset, SeatRotationYaw, SitAtBlock, true);
    }

    /**
     * Creates a new PoseSeat on a Block for a Player.
     * The PoseSeat can be static or rotating.
     * The PoseSeat can be moved to with an Offset
     * @author Gecolay
     * @since 1.0.4
     * @param Block Block which should be connected to the PoseSeat-Object
     * @param Player Player for this PoseSeat
     * @param Pose Player-Pose {@link Pose}
     * @param XOffset The X-Coordinate-Offset for the PoseSeat
     * @param YOffset The Y-Coordinate-Offset for the PoseSeat
     * @param ZOffset The Z-Coordinate-Offset for the PoseSeat
     * @param SeatRotationYaw The default Rotation of the PoseSeat
     * @param SitAtBlock Should the PoseSeat be aligned with the Block (<code>true</code>) or the Player (<code>false</code>)
     * @param GetUpSneak Should the Player be able to get up by sneaking
     * @return PoseSeat-Object or <code>null</code> if the creation was canceled
     */
    public static IGPoseSeat createPose(Block Block, Player Player, Pose Pose, double XOffset, double YOffset, double ZOffset, float SeatRotationYaw, boolean SitAtBlock, boolean GetUpSneak) {
        return getInstance().getPoseManager() != null ? getInstance().getPoseManager().createPose(Block, Player, Pose, XOffset, YOffset, ZOffset, SeatRotationYaw, SitAtBlock, GetUpSneak) : null;
    }

    /**
     * Removes an existing PoseSeat
     * @author Gecolay
     * @since 1.0.0
     * @param PoseSeat The PoseSeat
     * @param Reason The Reason why the PoseSeat gets removed
     * @return <code>true</code> or <code>false</code> if the deletion was canceled
     */
    public static boolean removePose(IGPoseSeat PoseSeat, GetUpReason Reason) {
        return getInstance().getPoseManager() != null && getInstance().getPoseManager().removePose(PoseSeat, Reason);
    }

    /**
     * Removes an existing PoseSeat.
     * The Get-Up-Safe-Teleport can be disabled
     * @author Gecolay
     * @since 1.0.0
     * @param PoseSeat The PoseSeat
     * @param Reason The Reason why the PoseSeat gets removed
     * @param Safe Should the Player get teleported to a safe Position
     * @return <code>true</code> or <code>false</code> if the deletion was canceled
     */
    public static boolean removePose(IGPoseSeat PoseSeat, GetUpReason Reason, boolean Safe) {
        return getInstance().getPoseManager() != null && getInstance().getPoseManager().removePose(PoseSeat, Reason, Safe);
    }

    /**
     * Checks if a Player is currently crawling
     * @author Gecolay
     * @since 1.0.0
     * @param Player Player for this Crawl-Object
     * @return <code>true</code> if the Player is crawling
     */
    public static boolean isCrawling(Player Player) {
        return getInstance().getCrawlManager() != null && getInstance().getCrawlManager().isCrawling(Player);
    }

    /**
     * Gets all Crawl-Objects
     * @author Gecolay
     * @since 1.0.0
     * @return List of all Crawl-Objects
     */
    public static List<IGCrawl> getCrawls() {
        return getInstance().getCrawlManager() != null ? getInstance().getCrawlManager().getCrawls() : new ArrayList<>();
    }

    /**
     * Gets the Crawl-Object of a Player
     * @author Gecolay
     * @since 1.0.0
     * @param Player Player for this Crawl-Object
     * @return Crawl-Object or <code>null</code> if there was no Crawl-Object
     */
    public static IGCrawl getCrawl(Player Player) {
        return getInstance().getCrawlManager() != null ? getInstance().getCrawlManager().getCrawl(Player) : null;
    }

    /**
     * Creates a new Crawl-Object for a Player
     * @author Gecolay
     * @since 1.0.0
     * @param Player Player for this Crawl-Object
     * @return Seat-Object or <code>null</code> if the creation was canceled
     */
    public static IGCrawl startCrawl(Player Player) {
        return getInstance().getCrawlManager() != null ? getInstance().getCrawlManager().startCrawl(Player) : null;
    }

    /**
     * Removes an existing Crawl-Object
     * @author Gecolay
     * @since 1.0.0
     * @param Crawl The Crawl-Object
     * @param Reason The Reason why the Crawl-Object gets removed
     * @return <code>true</code> or <code>false</code> if the deletion was canceled
     */
    public static boolean stopCrawl(IGCrawl Crawl, GetUpReason Reason) {
        return getInstance().getCrawlManager() != null && getInstance().getCrawlManager().stopCrawl(Crawl, Reason);
    }

}