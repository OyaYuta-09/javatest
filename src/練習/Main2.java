package 練習;

import java.util.Calendar;

public class Main2 {
	public static void main(String args[]){

		Calendar cal = Calendar.getInstance();	//[1]

		//主なCalendarメソッド
		//各種形式の取得
		System.out.println("[2] 年を表示 : " + cal.get(Calendar.YEAR));
		System.out.println("[3] 月を表示 : " + cal.get(Calendar.MONTH));
		System.out.println("[4] 日付を表示 : " + cal.get(Calendar.DATE));
		System.out.println("[5] 紀元前後を表示 : " + cal.get(Calendar.ERA));
		System.out.println("[6] 現在の年の何日目かを表示 : " + cal.get(Calendar.DAY_OF_YEAR));
		System.out.println("[7] 現在の月の何日目かを表示 : " + cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("[8] 曜日を表示 : " + cal.get(Calendar.DAY_OF_WEEK));
		System.out.println("[9] 現在の月の何度目の曜日かを表示 : " + cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println("[10] 現在の年の何週目かを表示 : " + cal.get(Calendar.WEEK_OF_YEAR));
		System.out.println("[11] 現在の月の何週目かを表示 : " + cal.get(Calendar.WEEK_OF_MONTH));

		System.out.println("[12] 年を表示(定数を使わない) : " + cal.get(1));

		//カレンダーの設定
		cal.set(Calendar.YEAR, 2017);
		System.out.println("[13] setで変更した日付を表示(年だけ指定) : " + getCalString(cal));

		cal.set(2016, 1, 1);
		System.out.println("[14] setで変更した日付を表示(年月日指定) : " + getCalString(cal));

		Calendar cal2 = Calendar.getInstance();
		System.out.println("[15] 新しいカレンダーオブジェクトを生成 : " + getCalString(cal2));

		//カレンダーの比較
		boolean ret;
		ret = cal.equals(cal2);
		System.out.println("[16] calとcal2が同じかどうか : " + String.valueOf(ret));

		ret  = cal.after(cal2);
		System.out.println("[17] calがcal2より後の日付かどうか : " + String.valueOf(ret));

		ret  = cal.before(cal2);
		System.out.println("[18] calがcal2より前の日付かどうか : " + String.valueOf(ret));

		cal.add(Calendar.MONTH, 1);
		System.out.println("[19] calにひと月加算 : " + getCalString(cal));

		//厳密な解釈を行い、ありえない日（2016年2月32日）を設定
		cal.setLenient(true);
		cal.set(2016,1,32);
		System.out.println("[20] 厳密な解釈をして、ありえない日を設定 : " +  getCalString(cal));

		//厳密な解釈を行わずに、ありえない日（2016年2月32日）を設定
		cal.setLenient(false);
		cal.set(2016,1,32);
		try{
			System.out.println("[21] 厳密な解釈をせずに、ありえない日を設定 : " + getCalString(cal));
		}catch(Exception ex){
			System.out.println("[21] 厳密な解釈をせずに、ありえない日を設定 するとエラーになる");
		}

		//値のクリア
		cal.clear();
		System.out.println("[22] 値をクリアする : " +  getCalString(cal));

	}
	//カレンダーを年月日の文字列で取得
	private static String  getCalString(Calendar tmpCal){

		return String.valueOf(tmpCal.get(Calendar.YEAR)) + "/" + String.valueOf(tmpCal.get(Calendar.MONTH)) + "/" + String.valueOf(tmpCal.get(Calendar.DATE));

	}
}