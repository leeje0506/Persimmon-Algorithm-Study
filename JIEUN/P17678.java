import java.util.*;

class P17678 {
    public String solution(int n, int t, int m, String[] timetable) {
        // 크루들 도착 시간을 분 단위로 변환하여 정렬
        int[] crewArrivalTimes = new int[timetable.length];
        for (int i = 0; i < timetable.length; i++) {
            crewArrivalTimes[i] = convertToMinutes(timetable[i]);
        }
        Arrays.sort(crewArrivalTimes);

        // 첫 버스 시간은 9:00 (540분)
        int busTime = 540;
        int lastTime = 0; // 콘이 타야 하는 최적의 시간
        int crewIndex = 0; // 현재 크루 인덱스

        for (int bus = 0; bus < n; bus++) {
            int count = 0; // 현재 버스에 탄 크루 수

            // 현재 버스에 크루를 태움
            while (count < m && crewIndex < crewArrivalTimes.length && crewArrivalTimes[crewIndex] <= busTime) {
                count++;
                crewIndex++;
            }

            // 마지막 버스인 경우, 콘이 탈 수 있는 시간 결정
            if (bus == n - 1) {
                if (count < m) {
                    // 마지막 버스에 자리가 남은 경우, 버스 도착 시간에 맞춰 타면 됨
                    lastTime = busTime;
                } else {
                    // 마지막 버스가 가득 찬 경우, 마지막 크루보다 1분 더 일찍 도착
                    lastTime = crewArrivalTimes[crewIndex - 1] - 1;
                }
            }

            // 다음 버스 도착 시간
            busTime += t;
        }

        return convertToTimeString(lastTime);
    }

    private int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }

    private String convertToTimeString(int minutes) {
        int hours = minutes / 60;
        int mins = minutes % 60;
        return String.format("%02d:%02d", hours, mins);
    }
}
