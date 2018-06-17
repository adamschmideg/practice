(ns hackerrank.fraudulent-activity)

(defn median [v]
  (let [sorted (vec (sort v))
        c (count sorted)
        half (quot c 2)]
    (if (odd? c)
      (get sorted half)
      (/ (+ (get sorted half) (get sorted (dec half))) 2))))

; Complete the activityNotifications function below.
(defn activityNotifications [expenditure d]
  (let [trailing (partition d 1 expenditure)
        check (drop d expenditure)
        warnings (map (fn [t c] (<= (* 2 (median t)) c)) trailing check)]
    (count (filter identity warnings))))

