package racingcar.view;

import racingcar.Constant;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Winner;
import racingcar.module.RacingRound;

public class ResultView {

    public static void printResultView(RacingRound resultRound, Cars cars) {
        int tryNum = resultRound.getRoundResult().size();
        Winner winner = new Winner(cars.getCars());

        for (int num = 0; num < tryNum; num++) {
            resultRound.getRoundResult().get(num).stream()
                    .map(ResultView::convertIntToString).forEach(System.out::println);
            System.out.println();
        }

        System.out.println(winner.getWinner() + "가 최종우승했습니다.");
    }

    private static String convertIntToString(Car car) {
        StringBuffer str = new StringBuffer();

        str.append(car.getName() + ":");
        for (int num = Constant.INPUT_ZERO_NUM; num < car.getPosition(); num++) {
            str.append("-");
        }
        return str.toString();
    }
}
