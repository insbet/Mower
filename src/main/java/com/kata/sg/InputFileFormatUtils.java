package com.kata.sg;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InputFileFormatUtils {

    public List<MowerInstructionsDto> mowerInstructionsDtos = new ArrayList<>();

    public List<MowerInstructionsDto> initMowers(String filePath) throws Exception {
        List<String> allLines = Files.readAllLines(
                Paths.get(this.getClass().getResource(filePath).toURI()), Charset.defaultCharset());
        if (allLines.isEmpty()) {
            return null;
        }
        if (allLines.size() % 2 == 0 && allLines.size() < 3) {
            return null;
        }
        Integer mowerNumber = 0;
        if (allLines.size() % 2 == 1) {
            mowerNumber = (allLines.size() - 1) / 2;
        }
        String[] maxPos = allLines.get(0).split(" ");
        for (int i = 0; i <= mowerNumber; i += 2) {
            String[] startPos = allLines.get(i + 1).split(" ");
            Position startPosition = new Position(Integer.parseInt(startPos[0]), Integer.parseInt(maxPos[0]), Integer.parseInt(startPos[1]), Integer.parseInt(maxPos[1]));
            List<DirectionEnum> directions = allLines.get(i + 2).codePoints().mapToObj(c -> DirectionEnum.valueOf(String.valueOf((char) c))).collect(Collectors.toList());
            mowerInstructionsDtos.add(new MowerInstructionsDto(new Mower(startPosition, OrientationEnum.valueOf(startPos[2])), directions));
        }
        return mowerInstructionsDtos;
    }
}
