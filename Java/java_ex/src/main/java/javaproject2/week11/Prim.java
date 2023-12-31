package javaproject2.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prim {
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer neTokenizer = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(neTokenizer.nextToken());
        int edgeCount = Integer.parseInt(neTokenizer.nextToken());

        // 가중치 저장 인접 행렬 사용
        int[][] adjMatrix = new int[nodeCount][nodeCount];
        for(int i = 0; i < edgeCount; i++) {
            StringTokenizer edgeTokenizer = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(edgeTokenizer.nextToken());
            int end = Integer.parseInt(edgeTokenizer.nextToken());
            int weight = Integer.parseInt(edgeTokenizer.nextToken());

            adjMatrix[start][end] = weight;
            adjMatrix[end][start] = weight;
        }

        // 방문정보
        boolean[] visited = new boolean[nodeCount];
        // 현재 선택된 정점들에서 해당 정점까지 도달 가능한 가장 짧은 거리
        int[] dist = new int[nodeCount];
        Arrays.fill(dist, Integer.MAX_VALUE);
        // 어느 노드에서 도달했는지 정보 저장
        int[] parent = new int[nodeCount];

        // 1. 임의 정점
        dist[0] = 0;
        parent[0] = -1;

        // 모든 정점을 선택할 때까지 순회
        for (int i = 0; i < nodeCount; i++) {
            int minDist = Integer.MAX_VALUE;
            int idx = -1;

            // 2-1. 인접한 정점 중 최소 비용 간선으로 연결되는 정점 찾기
            for (int j = 0; j < nodeCount; j++) {
                if (!visited[j] && dist[j] < minDist) {
                    minDist = dist[j];
                    idx = j;
                }
            }

            // 가장 가까운 곳 방문
            visited[idx] = true;

            // 2-2. 정점 정보를 바탕으로 도달 가능 정보를 갱신
            // idx로 부터 다른 정점들에 도달할 수 있는지를 확인하고 (adjMatrix)
            // 그 정보를 바탕으로 dist 배열 업데이트
            for (int j = 0; j < nodeCount; j++) {
                if (!visited[j] &&
                adjMatrix[idx][j] != 0 &&
                dist[j] > adjMatrix[idx][j]) {
                    dist[j] = adjMatrix[idx][j];
                    parent[j] = idx;
                }
            }
        }
        // Prim 알고리즘의 총 가중치는 dist 배열에 저장됨
        int totalWeight = 0;
        for (int i = 0; i < nodeCount; i++) {
            totalWeight += dist[i];
        }
        System.out.println(totalWeight);
        // 어떤 순서로 연결되었는지는 parent에 담김
        System.out.println(Arrays.toString(parent));

        return totalWeight;
    }

    public static void main(String[] args) throws IOException {
        new Prim().solution();
    }
}

/*
8 11
0 1 41
0 2 14
0 3 13
1 4 27
2 5 21
3 5 33
3 7 22
4 6 11
4 7 17
5 6 35
6 7 19
 */