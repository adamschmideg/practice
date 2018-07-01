(ns hackerrank.coin-change)

(def coin-change
  (memoize
    (fn [n coins]
      (cond
        (zero? n)
        1
        (neg? n)
        0
        (empty? coins)
        0
        :else
        (let [[greatest & rest] coins
              multiples (->> (range)
                            (map #(* % greatest))
                            (take-while #(<= % n)))
              changes (map #(coin-change (- n %) rest) multiples)
              sum (reduce + changes)]
          sum)))))

(defn getWays [n coins]
  (coin-change n (reverse (sort coins))))
