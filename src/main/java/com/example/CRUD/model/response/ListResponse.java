package com.example.CRUD.model.response;

import ch.qos.logback.core.util.StringUtil;
import com.example.CRUD.utils.ModelUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder(toBuilder = true)

public class ListResponse<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("data")
    private List<T> data;

    @JsonProperty("count")
    private Long count;

    @Override
    public int hashCode() {
        return Objects.hash(data, count);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListResponse ");
        sb.append("{\n    data: ").append(ModelUtils.toIndentedString(data));
        sb.append("\n    count: ").append(ModelUtils.toIndentedString(count));
        sb.append("\n}");
        return sb.toString();
    }
}
