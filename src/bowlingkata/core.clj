(ns bowlingkata.core)

(defn spare? [roll] (= \/ roll))
(defn strike? [roll] (= \X roll))

(defn turn-type [head next]
  (cond
    (strike? head) :strike
    (spare? next) :spare
    :else :normal))

(defn roll-score [roll]
  (case roll
    \X 10
    \- 0
    (read-string (str roll))))

(defn score
  "Calculate score for a series of rolls"
  [rolls]
  (loop [[head next after-next & tail :as all] rolls
         acc 0
         turn 0]
    (if (< turn 10)
      (let [turn-type (turn-type head next)
            current-score (case turn-type
                            :strike (+ acc (+ 10 (roll-score next) (roll-score after-next)))
                            :spare (+ acc 10 (roll-score after-next))
                            :normal (+ acc (roll-score head) (roll-score next)))
            new-tail (case turn-type
                       :strike (conj tail next after-next)
                       :spare (conj tail after-next)
                       :normal (conj tail after-next))]
        (recur new-tail current-score (inc turn)))
      acc)))


