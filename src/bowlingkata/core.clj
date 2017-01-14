(ns bowlingkata.core)

(defn score
  "Calculate score for a series of rolls"
  [rolls]
  (reduce + rolls))
