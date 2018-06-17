(ns hackerrank.fraudulent-activity-test
  (:require [clojure.test :refer :all]
            [hackerrank.fraudulent-activity :refer :all]))

(deftest simple-test
  (is (= (activityNotifications [2 3 4 2 3 6 8 4 5] 5)
        2)))

(run-tests)
