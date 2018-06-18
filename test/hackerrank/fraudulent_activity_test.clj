(ns hackerrank.fraudulent-activity-test
  (:require [clojure.test :refer :all]
            [hackerrank.fraudulent-activity :refer :all]))

(deftest insert-test
  (is (= (insert-into-sorted [2 4 6] 5) [2 4 5 6]))
  (is (= (insert-into-sorted [2 4 6] 4) [2 4 4 6]))
  (is (= (insert-into-sorted [2 4 6] 1) [1 2 4 6]))
  (is (= (insert-into-sorted [2 4 6] 8) [2 4 6 8])))

(deftest remove-test
  (is (= (remove-from-sorted [2 4 6] 4) [2 6]))
  (is (= (remove-from-sorted [2 4 4 6] 4) [2 4 6]))
  (is (= (remove-from-sorted [2 4 6] 2) [4 6]))
  (is (= (remove-from-sorted [2 4 6] 6) [2 4])))

(deftest simple-test
    (is (= (activityNotifications [2 3 4 2 3 6 8 4 5] 5)
          2)))

(run-tests)
