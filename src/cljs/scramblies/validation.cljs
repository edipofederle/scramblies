(ns scramblies.validation)

(defn or-empty-string
  "Return the original value or an empty string when the value is nil."
  [value]
  (or value ""))
