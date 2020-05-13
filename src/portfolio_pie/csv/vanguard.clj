(ns portfolio-pie.csv.vanguard
  (:require [portfolio-pie.input.csv :as csv]))

(defn vectorize [filepath]
  (let [rows (csv/vectorize filepath)]
    (map #(rest %) rows)))
