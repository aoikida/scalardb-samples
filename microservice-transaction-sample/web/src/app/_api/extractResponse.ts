export const extractResponseFromStdout = <R>(stdout: string): R => {
  const response = stdout.split("Task :client:run")[1].split("\n\n")[0];
  return JSON.parse(response);
};
