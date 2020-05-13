(ns portfolio-pie.output.writer)

(defn append [filepath content]
  (with-open [stream (clojure.java.io/writer filepath :append true)]
    (.write stream content)))

(defn write [filepath content]
  (with-open [stream (clojure.java.io/writer filepath)]
    (.write stream content)))
