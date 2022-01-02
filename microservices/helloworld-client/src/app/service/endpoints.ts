
export function helloworldEndpoint(name: string | undefined): string {
  return name ?
    'http://localhost:8001/' + name :
    'http://localhost:8001'
}
