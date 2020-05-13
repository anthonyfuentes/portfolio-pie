(ns portfolio-pie.casting.numbers)

(defn ->double [value]
  (try (Double/parseDouble value)
       (catch Exception e)))

(defn ->long [value]
  (try (Long/parseLong value)
       (catch Exception e)))

(defn ->number [value]
  (cond
    (number? value) value
    (string? value) (or (->long value) (->double value))
    :else nil))
