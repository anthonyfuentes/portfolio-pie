(ns portfolio-pie.input.csv
  (:require [clojure.data.csv :refer [read-csv]])
  (:require [clojure.java.io :as io]))

(defn vectorize [filepath]
  (let [stream (io/reader filepath)]
    (read-csv stream)))
