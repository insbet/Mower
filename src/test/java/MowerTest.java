import com.kata.sg.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


public class MowerTest {

    public static List<MowerInstructionsDto> mowerInstructionsDtos = new ArrayList<>();

    @BeforeAll
    public static void initConfig() throws Exception {
        InputFileFormatUtils inputFileFormatUtils = new InputFileFormatUtils();
        mowerInstructionsDtos = inputFileFormatUtils.initMowers("/InputFile.txt");
        assertEquals(2, mowerInstructionsDtos.size());
    }

    @Test
    public void shouldIncrementXWhenInferiorToLimitAndMoveRight() {
        Mower mower = new Mower(new Position(1, 10, 1, 10), OrientationEnum.E);
        mower.executeInstructions(Arrays.asList(DirectionEnum.A));
        assertEquals(2, mower.getPosition().getX());
        assertEquals(1, mower.getPosition().getY());
        assertEquals("E", mower.getOrientation().getCode());
    }

    @Test
    public void shouldNotIncrementXWhenLimitReached() {
        Mower mower = new Mower(new Position(10, 10, 1, 10), OrientationEnum.E);
        mower.executeInstructions(Arrays.asList(DirectionEnum.A));
        assertEquals(10, mower.getPosition().getX());
        assertEquals(1, mower.getPosition().getY());
        assertEquals("E", mower.getOrientation().getCode());

    }

    @Test
    public void shouldTurnLeftWhenDirectionG() {
        Mower mower = new Mower(new Position(1, 10, 1, 10), OrientationEnum.E);
        mower.executeInstructions(Arrays.asList(DirectionEnum.G));
        assertEquals("N", mower.getOrientation().getCode());

    }

    @Test
    public void shouldTurnRightWhenDirectionD() {
        Mower mower = new Mower(new Position(1, 10, 1, 10), OrientationEnum.E);
        mower.executeInstructions(Arrays.asList(DirectionEnum.D));
        assertEquals("S", mower.getOrientation().getCode());
    }

    @Test
    public void shouldExecuteMultipleInstructionsGAGAA() {
        Mower mower = new Mower(new Position(5, 10, 1, 10), OrientationEnum.E);
        mower.executeInstructions(Arrays.asList(DirectionEnum.G, DirectionEnum.A, DirectionEnum.G, DirectionEnum.A, DirectionEnum.A));
        assertEquals(3, mower.getPosition().getX());
        assertEquals(2, mower.getPosition().getY());
        assertEquals("W", mower.getOrientation().getCode());
    }

    @Test
    public void shouldReturnExpectedResultsWithTestFirstEntry() {
        MowerInstructionsDto mowerInstructionsDto = mowerInstructionsDtos.get(0);
        Mower secondMower = mowerInstructionsDto.getMower();
        secondMower.executeInstructions(mowerInstructionsDto.getDirections());
        assertEquals(1, secondMower.getPosition().getX());
        assertEquals(3, secondMower.getPosition().getY());
        assertEquals("N", secondMower.getOrientation().getCode());
    }

    @Test
    public void shouldReturnExpectedResultsWithTestSecondEntry() {
        MowerInstructionsDto mowerInstructionsDto = mowerInstructionsDtos.get(1);
        Mower firstMower = mowerInstructionsDto.getMower();
        firstMower.executeInstructions(mowerInstructionsDto.getDirections());
        assertEquals(5, firstMower.getPosition().getX());
        assertEquals(1, firstMower.getPosition().getY());
        assertEquals("E", firstMower.getOrientation().getCode());
    }

}
