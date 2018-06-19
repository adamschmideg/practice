(ns hackerrank.balanced-brackets)

(def pairs {\{ \}, \( \), \[ \]})

(defn balanced? [s stack]
  (if (empty? s)
    (empty? stack)
    (let [[c & rest] s]
      (if (= c (pairs (peek stack)))
        (recur rest (pop stack))
        (recur rest (conj stack c))))))

(defn isBalanced [s]
  (if (balanced? s []) "YES" "NO"))

