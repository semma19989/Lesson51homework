package kg.attractor.demo.annotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/***
 * Swagger 2 handles parameters with the Pageable data type crookedly
 *  * And this annotation is used to fix this problem
 *  * This annotation must be applied to the controller method,
 *  * where Pageable is applied
 * *
 *  * This annotation is only required when using Swagger 2
 * *
 *  * In addition to this annotation, you must specify @ApiIgnore for the Pageable parameter
 *  * For example:
 *  * <b>@ApiPageable</b>
 *  * * public List & lt;MovieDTO&gt; find Movies(<b>@ApiIgnore</b> Pageable pageable) {
 */

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ApiImplicitParams({
        @ApiImplicitParam(name = "page", dataType = "int", paramType = "query", defaultValue = "0", value = "Results page you want to retrieve (0..N)"),
        @ApiImplicitParam(name = "size", dataType = "int", paramType = "query", defaultValue = "20", value = "Number of records per page."),
        @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value = "Sorting criteria in the format: property(,asc|desc). "
                + "Default sort order is ascending. " + "Multiple sort criteria are supported.")})
@interface ApiPageable {
}