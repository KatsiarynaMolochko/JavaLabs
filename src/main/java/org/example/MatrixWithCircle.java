package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

import static java.lang.Math.sqrt;

public class MatrixWithCircle {
    private ArrayList<ArrayList<Boolean>> matrix = new ArrayList<>();
    private TreeMap<Double, ArrayList<Dot>> map = new TreeMap<>();

    MatrixWithCircle(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = reader.readLine();

        StringTokenizer tokenizer = new StringTokenizer(line, " ");
        ArrayList<Integer> res = new ArrayList<>();

        while (tokenizer.hasMoreTokens()) {
            res.add(Integer.parseInt(tokenizer.nextToken()));
        }

        init(res.get(0), res.get(1), res.get(2), new Dot(res.get(3), res.get(4)));
    }

    private void init(Integer n, Integer m, Integer radius, Dot circleCenter) {
        for (int i = 0; i < n; ++i) {
            ArrayList<Boolean> initial = new ArrayList<>();

            for (int j = 0; j < m; ++j) {
                initial.add(false);
            }

            matrix.add(initial);
        }

        if (circleCenter.x >= n || circleCenter.x < 0 || circleCenter.y >= m || circleCenter.y < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        ArrayList<Boolean> line = matrix.get(circleCenter.x);
        line.set(circleCenter.y, true);
        matrix.set(circleCenter.x, line);

        Dot circleCenterDot = new Dot(circleCenter.x, circleCenter.y);
        for (int i = 0; i < matrix.size(); ++i) {
            for (int j = 0; j < matrix.get(i).size(); ++j) {
                Dot current = new Dot(i, j);
                Double distance = calcDistance(current, circleCenterDot);

                if (distance <= radius) {
                    ArrayList<Boolean> row = matrix.get(i);
                    row.set(j, true);
                    matrix.set(i, row);

                    if (map.containsKey(distance)) {
                        ArrayList<Dot> dotsList = map.get(distance);
                        if (!dotsList.contains(current)) {
                            dotsList.add(current);
                        }

                        map.remove(distance);
                        map.put(distance, dotsList);
                    } else {
                        ArrayList<Dot> newDotList = new ArrayList<>();
                        newDotList.add(current);
                        map.put(distance, newDotList);
                    }


                }
            }
        }
    }

    public Double calcDistance(Dot first, Dot second) {
        return sqrt((second.y - first.y) * (second.y - first.y) + (second.x - first.x) * (second.x - first.x));
    }

    public void writeResult(String filename) {
        writeStudentsArrayListToFile(filename);
    }

    private void writeStudentsArrayListToFile(String fileName) {
        try(FileWriter out = new FileWriter(fileName)) {
            for (Double treeKey : map.keySet()) {
                for (int i = 0;  i < map.get(treeKey).size(); ++i) {
                    out.write(map.get(treeKey).get(i).x.toString());
                    out.write(" ");
                    out.write(map.get(treeKey).get(i).y.toString());
                    out.write("\n");
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
