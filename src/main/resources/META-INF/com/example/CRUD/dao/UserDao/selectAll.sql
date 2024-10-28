SELECT *
FROM users
WHERE
    name LIKE /* @infix(request.name) */''
OR
    email LIKE /* @prefix(request.email) */''
 ORDER BY id ASC
LIMIT /* pagination.getLimit() */0
OFFSET /* (pagination.getLimit()*pagination.getPage()) */10